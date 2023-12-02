class DoorSecurity extends HTMLElement {

    constructor() {
        
        super();
        
        const shadow = this.attachShadow({ mode: "open" });
       
        $.ajax({
            async: false,
            url: './components/aweit_ds_door/aweit_ds_door.html',
            dataType: 'text', 
            success: function ( html ){
                const root = document.createElement('div');
                root.setAttribute('id', 'root');
                root.innerHTML = html;
                shadow.appendChild(root);
            },
        });

        const handleClick = () => {
            const customClickEvent = new Event('ds-door-click');
            this.dispatchEvent(customClickEvent);
        };
        shadow.addEventListener('click', handleClick);
    }

    connectedCallback() {
    }

    static get observedAttributes() {
        return ["status","type"];
    }

    attributeChangedCallback(name, oldValue, newValue) {
        //console.log(`属性 ${name} 已由 ${oldValue} 变更为 ${newValue}。`);
        this.updateStyle(this,name,newValue);
    }

    updateStyle(elem, name, value) {
        const shadow = elem.shadowRoot;
        const root = shadow.querySelector('#root');
        const door = root.querySelector('#door');
        const type = this.getAttribute('type');

        door.querySelector('#door_name').innerHTML = this.getAttribute('door_name');
        door.querySelector('#door_id').innerHTML = this.getAttribute('door_id');
        if(type == 'employee') {
            if (name === 'status' && value == 1) {
                door.querySelector('#door_pic').classList.remove('bi-door-closed');
                door.querySelector('#door_pic').classList.add('bi-door-open');
                door.querySelector('#door_stop').classList.add('d-none');
                door.querySelector('#door_status').innerHTML = 'Open';
                door.querySelector('#door_status').classList.remove('text-danger');
                door.querySelector('#door_status').classList.add('text-success');
            } else if(name === 'status' && value <= 0) {
                door.querySelector('#door_pic').classList.add('bi-door-closed');
                door.querySelector('#door_pic').classList.remove('bi-door-open');
                door.querySelector('#door_stop').classList.remove('d-none');
                door.querySelector('#door_status').innerHTML = 'Close';
                door.querySelector('#door_status').classList.add('text-danger');
                door.querySelector('#door_status').classList.remove('text-success');
                if(value< 0) {
                    door.querySelector('#door_stop').classList.add('d-none');
                }
            }
        }
        if(type == 'door') {

            door.querySelector('#door_pic').classList.remove('bi-door-closed');
            door.querySelector('#door_pic').classList.add('bi-door-open');
            door.querySelector('#door_stop').classList.add('d-none');
            door.querySelector('#door_status').innerHTML = '';
            door.querySelector('#door_status').classList.remove('text-danger');
            door.querySelector('#door_status').classList.remove('text-success');
        }
    }

    registerClickHandler(handler) {
        this.addEventListener('ds-door-click', handler);
    }
}

customElements.define("aweit-ds-door", DoorSecurity);