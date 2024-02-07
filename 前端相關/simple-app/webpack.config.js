const path = require("path");
const CopyWebPackPlugin = require("copy-webpack-plugin");
const CompressionPlugin = require("compression-webpack-plugin");

module.exports = {
    mode: 'development',
    resolve: {
        alias: {
            '@': path.resolve(__dirname,'src'),
        }
    },
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
                use: ['style-loader', 'css-loader', 'postcss-loader'],
            }
        ] 
    },
    devServer: {
        static: './public',
    },
}