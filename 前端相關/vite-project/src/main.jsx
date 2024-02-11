import React from 'react'
import ReactDOM from 'react-dom/client'
// import App from './App.jsx'
import Gallery from './Gallery.jsx'
import Card from './Card.jsx';
import PackingList from './PackingList.jsx';
import List from './List.jsx';
import SideBar from './SideBar.jsx';
import Search from './Search.jsx';
import Toolbar from './Toolbar.jsx';
import Post from './Post.jsx';
import './index.css';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <div className=' flex items-start flex-wrap justify-start'>
      <Gallery />
      <Card/>
      <PackingList/>
      <List/>
      <SideBar/>
      <Search/>
      <Toolbar onPlayMovie={()=> alert('Playing Movie')} onUploadImage={()=> alert('Uploading Image...')}/>
      <Post/>
    </div>
  </React.StrictMode>,
)
