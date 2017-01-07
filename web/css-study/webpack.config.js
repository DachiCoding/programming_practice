const path = require('path');
const webpack = require('webpack');
const HtmlwebpackPlugin = require('html-webpack-plugin')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

module.exports = {

    //devtoll
    //devtool: 'cheap-module-source-map',
    
    //devserver
    devServer: { inline: true},

    //Entry
    entry: "./src/index.js",

    //Output
    output: {
        path: path.resolve(__dirname,'./dist'),
        filename: "bundle.js"
    },
    
    //模块loader
    module: {
        loaders: [
        {
            test: /\.js$/,
            exclude: /node_modules/,
            loader: 'babel-loader',
            query: {
                presets: ['es2015']
            }
        },
        {test: /\.less$/, loader: 'style!css!less'}
        ]
    },

    //插件
    plugins: [
        new ExtractTextPlugin("style.css")
    ]
}
