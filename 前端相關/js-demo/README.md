### 如何安裝 PostCSS

1. npm install postcss postcss-preset-env --save-dev

2. 创建 PostCSS 配置文件：在项目根目录下创建一个名为 postcss.config.js 的文件，并添加以下内容：

    ```
    module.exports = {
    plugins: {
        'postcss-preset-env': {}
    }
    };
    ```
3. npx postcss styles.css --output output.css