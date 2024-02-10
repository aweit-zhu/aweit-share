const path = require("path");
const fs = require("fs");
const publicDir = path.resolve(__dirname, "public");
const CopyWebPackPlugin = require("copy-webpack-plugin");
const CompressionPlugin = require("compression-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackPlugin = require("html-webpack-plugin");

module.exports = {
  mode: "development",
  resolve: {
    alias: {
      "@": [path.resolve(__dirname, "src"), path.resolve(__dirname, "public")],
    },
  },
  devtool: "source-map",
  plugins: [
    new CompressionPlugin(),
    new CopyWebPackPlugin({
      patterns: [
        {
          from: path.resolve(__dirname, "public"),
          filter: (resourcePath) => !resourcePath.endsWith(".html"),
        },
      ],
    }),
    ...getHtmlWebpackPluginInstances(),
    new MiniCssExtractPlugin(),
  ],
  output: {
    clean: true,
  },
  module: {
    rules: [
      {
        test: /\.css$/i,
        use: [MiniCssExtractPlugin.loader, "css-loader", "postcss-loader"], //'style-loader'
      },
      {
        test: /\.(?:js|mjs|cjs)$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: [
              ["@babel/preset-env", { targets: "defaults" }],
              //   ['@babel/preset-env']
            ],
          },
        },
      },
      {
        test: /\.html$/i,
        loader: "html-loader",
      },
    ],
  },
  devServer: {
    static: "./public",
  },
  stats: {
    // ids: true,
    modulesSpace: 999,
    //chunks: true,
  },
  optimization: {
    // moduleIds: 'natural',
    //chunkIds: 'named'
    minimize: true,
  },
};

/**
 *  // new HtmlWebpackPlugin({
    //     filename: 'index.html',
    //     template: path.resolve(__dirname,'public','index.html'),
    // }),
 * @returns 
 */
function getHtmlWebpackPluginInstances() {
  const instances = [];
  const /** @type {Array<string>} */ filePaths = traverseDirectory(publicDir)
  filePaths.forEach((filePath) => {
    const {dir, name } = path.parse(filePath);
    const outputPath = path.join( dir.replace('public','dist') ,name + '.html');
    instances.push(new HtmlWebpackPlugin({
        filename: outputPath,
        template: filePath,
    }));
  });
  return instances;
}

function traverseDirectory(dirPath) {
    const files = fs.readdirSync(dirPath, { withFileTypes: true });
    const filePaths = []; 
    files.forEach(file => {
        const filePath = path.join(dirPath, file.name);
        if (file.isDirectory()) {
            filePaths.push(...traverseDirectory(filePath));
        } else {
            filePaths.push(filePath);
        }
    });

    return filePaths;
}
