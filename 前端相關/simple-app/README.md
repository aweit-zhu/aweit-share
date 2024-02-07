### Webpack 

1. 專案初始化 `npm init -y`
2. 安裝 http-server: `npm install http-server --save-dev`
3. 基本安裝: `npm install webpack webpack-cli --save-dev`
4. css loader: `npm install style-loader css-loader --save-dev`
5. CopyWebpackPlugin: `npm install copy-webpack-plugin --save-dev` 可以把檔案從A地，移到B地
6. 因為複雜的關係，所以需要建立一個設定檔: `wenpack-config.js`
7. 改用 webpack-dev-server: `npm install webpack-dev-server --save-dev`、`npm uninstall http-server --save-dev`

### 大招

1. `https://createapp.dev/`


### tailwind css <https://gsc13.medium.com/how-to-configure-webpack-5-to-work-with-tailwindcss-and-postcss-905f335aac2>

1. 安裝postcss: `npm install --save-dev css-loader style-loader postcss-loader autoprefixer`
   (可選) `npm install --save-dev mini-css-extract-plugin html-webpack-plugin`
2. 調整webpack.config.js: 

```
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
```

3. 修改 style.css

```
@tailwind base;
@tailwind components;
@tailwind utilities;
```

4. 新增tailwindcss設定檔: `npx tailwindcss init`
tailwind.config.js
```
/** @type {import('tailwindcss').Config} */
module.exports = {
  purge: [
    './public/**/*.html',
    './src/**/*.js'
  ],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {},
  },
  variants: {
    extend: {},
  },
  plugins: [],
}

```

5. 新增 postcss.config.js

```
module.exports = {
  plugins: [
    require('tailwindcss'),
    require('autoprefixer')
  ]
};
```