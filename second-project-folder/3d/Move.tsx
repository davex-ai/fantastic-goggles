 "use client"

import { Canvas, useFrame } from "@react-three/fiber"
import { MeshDistortMaterial, Sphere } from "@react-three/drei"
import { useRef } from "react"
import * as THREE from "three"

function OrbMesh() {
  const mesh = useRef<THREE.Mesh>(null!)

  useFrame((_, delta) => {
    mesh.current.rotation.y += delta * 0.2
    mesh.current.rotation.x += delta * 0.1
  })

  return (
    <Sphere args={[1.2, 64, 64]} ref={mesh}>
      <MeshDistortMaterial
        color="#7c3aed"
        emissive="#7c3aed"
        distort={2.35}
        speed={4.9}
        roughness={2.2}
      />
    </Sphere>
  )
}

export default function Rotate() {
  return (
    <Canvas camera={{ position: [0, 0, 4] }}>
      <ambientLight intensity={1.5} />
      <directionalLight position={[5, 5, 5]} />
      <OrbMesh />
    </Canvas>
  )
}


your the fucking Hiroshima and 9/11 of all human beings
u miserable junkie bumfuck