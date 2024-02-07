const path = require("path");
const fs = require('fs');
const publicDir = path.resolve(__dirname, 'public');
const CopyWebPackPlugin = require("copy-webpack-plugin");
const CompressionPlugin = require("compression-webpack-plugin");
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: 'development',
    resolve: {
        alias: {
            '@': path.resolve(__dirname,'src'),
        }
    },
    devtool: 'source-map',
    plugins: [
        new CompressionPlugin(),
        new CopyWebPackPlugin({
            patterns: [
                {
                    from: path.resolve(__dirname,'public'),
                    filter: (resourcePath) => !resourcePath.endsWith('.html'),
                }
            ]
        }),
        // new HtmlWebpackPlugin({
        //     filename: 'index.html',
        //     template: path.resolve(__dirname,'public','index.html'),
        // }),
        ...getHtmlWebpackPluginInstances(),
        new MiniCssExtractPlugin()
    ],
    output: {
        clean: true
    },
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: [MiniCssExtractPlugin.loader, 'css-loader', 'postcss-loader'] , //'style-loader'
            },
            {
                test: /\.(?:js|mjs|cjs)$/,
                exclude: /node_modules/,
                use: {
                  loader: 'babel-loader',
                  options: {
                    presets: [
                      ['@babel/preset-env', { targets: "defaults" }]
                    //   ['@babel/preset-env']
                    ]
                  }
                }
            }
        ] 
    },
    devServer: {
        static: './public',
    },
    stats: {
        // ids: true,
        modulesSpace: 999,
        //chunks: true,
    },
    optimization: {
       // moduleIds: 'natural',
        //chunkIds: 'named'
        minimize: true
    }
}

function getHtmlWebpackPluginInstances() {
    const instances = [];
    const templates  = fs.readdirSync(publicDir);
    const templatePath = (name) => path.resolve(__dirname, `public/${name}`);
    templates.forEach((template) => {
        const options = {
          filename: `${template}`,
          template: templatePath(template),
        };
        instances.push(new HtmlWebpackPlugin(options));
    }); 
    return instances;  
}

//console.log(getHtmlWebpackPluginInstances());