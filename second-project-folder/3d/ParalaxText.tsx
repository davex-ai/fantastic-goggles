"use client"

import { Canvas } from '@react-three/fiber'
import { OrbitControls, Text } from '@react-three/drei'
import { useFrame } from '@react-three/fiber'
import { useState, useRef } from 'react'
import { Group } from 'three'

const faces = [
  { text: '💻', color: '#0066cc' },
  { text: '🛠️', color: '#ff9900' },
  { text: '📖', color: '#4caf50' },
  { text: '🎨', color: '#e91e63' },
  { text: '🌐', color: '#9c27b0' },
  { text: '🚀', color: '#ff5722' },
]

function RotatingCube() {
  const [isHovered, setIsHovered] = useState(false)
  const cubeRef = useRef<Group>(null)

  useFrame(() => {
    if (!isHovered && cubeRef.current) {
      cubeRef.current.rotation.y += 0.005
    }
  })

  return (
    <group ref={cubeRef}>
      <mesh
        scale={1.5}
        onPointerOver={() => setIsHovered(true)}
        onPointerOut={() => setIsHovered(false)}
      >
        <boxGeometry args={[1, 1, 1]} />
        <meshStandardMaterial 
          color="#ffffff" 
          roughness={0.5} 
          metalness={0.1}
        />
{faces.map((face, i) => {
  let pos: [number, number, number] = [0, 0, 0]
  let rot: [number, number, number] = [0, 0, 0]

  switch (i) {
    case 0: pos = [0.5, 0, 0.01]; break // front → slightly forward
    case 1: pos = [-0.5, 0, -0.01]; break // back → slightly backward
    case 2: pos = [0, 0.5, 0.01]; rot = [Math.PI / 2, 0, 0]; break // top → slightly up
    case 3: pos = [0, -0.5, -0.01]; rot = [-Math.PI / 2, 0, 0]; break // bottom → slightly down
    case 4: pos = [0, 0, 0.51]; rot = [0, Math.PI / 2, 0]; break // right → slightly right
    case 5: pos = [0, 0, -0.51]; rot = [0, -Math.PI / 2, 0]; break // left → slightly left
  }

  return (
    <Text
      key={i}
      position={pos}
      rotation={rot}
      fontSize={0.7}
      color={face.color}
      anchorX="center"
      anchorY="middle" 
      renderOrder={1}
      font="https://cdn.jsdelivr.net/npm/@fontsource/roboto@4.5.0/files/roboto-latin-400-normal.woff"
    >
      {face.text}
    </Text>
  )
})}
      </mesh>
    </group>
  )
}

export default function StoryCube() {
  return (
    <div className="w-full max-w-md mx-auto mt-8">
      <Canvas
        className="w-full h-64 bg-white rounded-lg shadow-lg"
        camera={{ position: [0, 0, 3], fov: 60 }}
      >
        <ambientLight intensity={Math.PI} />
        <directionalLight position={[1, 1, 1]} intensity={Math.PI} />
        <directionalLight position={[-1, -1, -1]} intensity={Math.PI / 2} />

        <RotatingCube />

        <OrbitControls
          enableZoom={false}
          enablePan={false}
          enableRotate={false}
        />
      </Canvas>
    </div>
  )
}