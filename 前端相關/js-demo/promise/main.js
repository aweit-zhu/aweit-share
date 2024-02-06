
// 異步請求
// const fetchPromise = fetch(
//     "https://mdn.github.io/learning-area/javascript/apis/fetching-data/can-store/products.json",
// );

// console.log(fetchPromise);

// fetchPromise.then((response) => {
//     if (!response.ok) {
//         throw new Error(`HTTP error: ${response.status}`);
//     }
//     return response.json();
// }).then(json => {
//     console.log(json[0].name);
// }).catch((error) => {
//     console.error(`无法获取产品列表：${error}`);
// });
// console.log("已发送请求……");

// 異步請求中的同步處理
// async function fetchProducts() {
//     try {
//         const response = await fetch(
//             "https://mdn.github.io/learning-area/javascript/apis/fetching-data/can-store/products.json",
//         );
//         if (!response.ok) {
//             throw new Error(`HTTP 请求错误：${response.status}`);
//         }
//         const json = await response.json();
//         return json;
//     } catch (error) {
//         console.error(`无法获取产品列表：${error}`);
//     }
// }

// async function submit() {
//     console.log('請求開始');
//     const json = await fetchProducts();
//     console.log(json);
//     console.log('請求結束');
// }
// submit();

// 如果在這邊執行fetchProducts()，它返回的還是 Promise物件
// const jsonPromise = fetchProducts();
// jsonPromise.then((json) => console.log(json[0].name));



const output = document.querySelector("#output");
const button = document.querySelector("#set-alarm");

// function setAlarm() {
//   window.setTimeout(() => {
//     output.textContent = "Wake up!";
//   }, 1000);
// }

//button.addEventListener("click", setAlarm);

// 鬧鐘應該可以共用，不應該寫非鬧鐘的動作，所以應該要把元素更新的動作交由 Button
const setAlarm = (person, delay) => {
    return new Promise((resolve, reject) => {
        if (delay < 0) {
            throw new Error("Alarm delay must not be negative");
        }
        window.setTimeout(()=> {
            resolve(`Wake up, ${person}`);
        },delay);
    });
};

button.addEventListener('click', ()=> {
    output.textContent = '';
    setAlarm('aweit',1000)
    .then(message => output.textContent = message)
    .catch(error => output.textContent = `Couldn't set alarm: ${error}`);
});