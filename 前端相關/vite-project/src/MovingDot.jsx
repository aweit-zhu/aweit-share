import { useState } from "react";

export default function MovingDot() {
  const [position, setPosition] = useState({ x: 0, y: 0 });

  return (
    <>
      <div className='w-1/3 p-2 shadow overflow-y-auto h-96 bg-black'>
        <div
            onPointerMove={(e) => {
                setPosition({
                    ...position,
                    x: e.clientX,
                    y: e.clientY,
                });
            }}
            style={{
            position: "relative",
            width: "100%",
            height: "100%",
            }}
        >
            <div
                style={{
                    position: "fixed",
                    backgroundColor: "red",
                    borderRadius: "50%",
                    transform: `translate(${position.x}px, ${position.y}px)`,
                    left: -10,
                    top: -10,
                    width: 20,
                    height: 20,
                }}
            />
        </div>
      </div>
    </>
  );
}
