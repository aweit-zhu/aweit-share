import Profile from './Profile.jsx';

export default function Gallery() {
  return (
    <section className=" w-1/3 p-2 shadow mx-auto mt-2">
      <h1 className=" text-xl font-bold m-2">Amazing scientists</h1>
      <div className="flex justify-start w-40 m-2">
        <Profile />
        <Profile />
        <Profile />
      </div>
    </section>
  );
}
