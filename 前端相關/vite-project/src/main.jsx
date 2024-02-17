import React from "react";
import ReactDOM from "react-dom/client";
// import App from './App.jsx'
import Gallery from "./Gallery.jsx";
import Card from "./Card.jsx";
import PackingList from "./PackingList.jsx";
import List from "./List.jsx";
import SideBar from "./SideBar.jsx";
import Search from "./Search.jsx";
import Toolbar from "./Toolbar.jsx";
import Post from "./Post.jsx";
import Form from "./Form.jsx";
import "./index.css";
import ClockApp from "./Clock.jsx";
import CounterApp from "./Counter.jsx";
import MovingDot from "./MovingDot.jsx";
import FormTezz from "./FormTezz.jsx";
import ShortMsg from "./ShortMsg.jsx";
import Task from "./Task.jsx";
import UserProvder from "./provider/UserProvider.jsx";
import Login from "./login.jsx";
import { VideoPlayerApp } from "./VideoPlayer.jsx";
import { ChatRoomApp } from "./ChatRoom.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <>
      <UserProvder>
        <SideBar />
        <div className=" flex items-start flex-wrap justify-start">
          <Gallery />
          <Card />
          <PackingList />
          <List />
          <Search />
          <Toolbar
            onPlayMovie={() => alert("Playing Movie")}
            onUploadImage={() => alert("Uploading Image...")}
          />
          <Post />
          <Form />
          <ClockApp />
          <CounterApp />
          {/* <MovingDot/> */}
          <FormTezz />
          <ShortMsg />
          <Task />
          <Login/>
          <VideoPlayerApp/>
          <ChatRoomApp/>
        </div>
      </UserProvder>
    </>
  </React.StrictMode>
);
