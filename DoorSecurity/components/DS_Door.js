var bs_css = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css';
var bsIcon_css = 'https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css';
var bs_js = 'https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js';

var doorClose = `
    <div class="d-flex flex-column justify-content-center align-items-center position-relative my-2 ds-tooltip" role="button">
        <p class="my-0 position-absolute text-danger status">Close</p>
        <i class="bi bi-door-closed mx-2"></i>
        <p class="my-0 position-absolute title">doorName</p>
        <span class="ds-tooltiptext">Open Door</span>
    </div>
`;

var doorOpen = `
    <div class="d-flex flex-column justify-content-center align-items-center position-relative my-2 ds-tooltip" role="button">
        <p class="my-0 position-absolute text-success status">Open</p>
        <i class="bi bi-door-open mx-2"></i>
        <p class="my-0 position-absolute title">doorName</p>
        <span class="ds-tooltiptext">Close Door</span>
    </div>
`;

var doorStop = `
    <div class="d-flex flex-column justify-content-center align-items-center position-relative my-2">
        <p class="my-0 position-absolute text-danger status">Close</p>
        <i class="bi bi-door-closed mx-2"></i>
        <p class="my-0 position-absolute title">doorName</p>
        <i class="bi bi-lock-fill position-absolute stop"></i>
    </div>
`;

var style = `
    i {
        font-size:28px;
        top:2em;
    }

    .status {
        font-size:6px;
        top:-1px;
        font-weight: bold;
    }

    .title {
        font-size: 5px;
        bottom: -2px;
        font-weight: bold;
    }

    .stop {
        top: 12px;
        font-size: 12px;
        color: red;
    }

    .ds-tooltip {
        position: relative;
        display: inline-block;
    }
      
    .ds-tooltip .ds-tooltiptext {
        cursor: pointer;
        visibility: hidden;
        font-size: 3px;
        bottom: 15px;
        font-weight: bold;
        background-color: black;
        color: #fff;
        text-align: center;
        border-radius: 2px;
        padding: 1px;
        position: absolute;
        z-index: 1;
    }
      
    .ds-tooltip:hover .ds-tooltiptext {
        visibility: visible;
    }
`;

class DS_Door extends HTMLElement {

    constructor() {
        super();
        const shadow = this.attachShadow({ mode: "open" });

        // 加入樣式
        const styleObj = document.createElement("style");
        styleObj.textContent = style;
        shadow.appendChild(styleObj);

        // 加入 Bootstap5
        const bootstrapLink = document.createElement('link');
        bootstrapLink.rel = 'stylesheet';
        bootstrapLink.href = bs_css;
        shadow.appendChild(bootstrapLink);

        // 加入 Bootstap5 Icon
        const bootstrapIconLink = document.createElement('link');
        bootstrapIconLink.rel = 'stylesheet';
        bootstrapIconLink.href = bsIcon_css;
        shadow.appendChild(bootstrapIconLink);

        // 加入 Bootstap5
        const jqueryScript = document.createElement('script');
        jqueryScript.src = bs_js;
        shadow.appendChild(jqueryScript);

        // 註冊事件
        const handleClick = () => {
            const customClickEvent = new Event('ds-door-click');
            this.dispatchEvent(customClickEvent);
        };
        shadow.addEventListener('click', handleClick);;

        // 加入元素
        const root = document.createElement('div');
        root.setAttribute('id', 'root');
        root.innerHTML = doorClose;
        shadow.appendChild(root);
    }

    connectedCallback() {
        //this.updateStyle(this);
    }

    static get observedAttributes() {
        return ["status"];
    }

    attributeChangedCallback(name, oldValue, newValue) {
        //console.log(`属性 ${name} 已由 ${oldValue} 变更为 ${newValue}。`);
        this.updateStyle(this,name,newValue);
    }

    updateStyle(elem, name, value) {
        const shadow = elem.shadowRoot;
        const root = shadow.querySelector('#root');

        if (name === 'status' && value == 1) {
            root.innerHTML = doorOpen.replace("doorName", this.getAttribute('door_name'))
        } else if(name === 'status' && value == 0) {
            root.innerHTML = doorClose.replace("doorName", this.getAttribute('door_name'))
        } else if(name === 'status' && value == -1) {
            root.innerHTML = doorStop.replace("doorName", this.getAttribute('door_name'))
        }
    }

    registerClickHandler(handler) {
        this.addEventListener('ds-door-click', handler);
    }
}

customElements.define("ds-door", DS_Door);