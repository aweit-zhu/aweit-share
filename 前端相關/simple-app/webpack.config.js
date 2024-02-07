const path = require("path");
const CopyWebPackPlugin = require("copy-webpack-plugin");
const CompressionPlugin = require("compression-webpack-plugin");

module.exports = {
    mode: 'development',
    plugins: [
        new CompressionPlugin(),
        new CopyWebPackPlugin({
            patterns: [{from: path.resolve(__dirname,'public')}]
        }),
    ],
    output: {
        clean: true
    },
    module: {
        rules: [
            {
                test: /\.css$/i,
                use: ['style-loader',
                {
                  loader: 'css-loader',
                  options: {
                    importLoaders: 1
                  }
                },
                'postcss-loader'],
            }
        ] 
    },
    devServer: {
        static: './public',
    },
}