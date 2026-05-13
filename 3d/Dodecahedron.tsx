"use client"

import { Canvas, useFrame, useThree } from "@react-three/fiber"
import { Dodecahedron } from "@react-three/drei"
import { useRef } from "react"
import * as THREE from "three"
import { EffectComposer, Bloom } from "@react-three/postprocessing"

function OrbMesh() {
  const mesh = useRef<THREE.Mesh>(null)
  const { pointer } = useThree()

  useFrame(() => {
    if (!mesh.current) return

    mesh.current.rotation.y += 0.01
    mesh.current.rotation.x += 0.005

    mesh.current.position.x = THREE.MathUtils.lerp(
      mesh.current.position.x,
      pointer.x * 0.3,
      0.1
    )
    mesh.current.position.y = THREE.MathUtils.lerp(
      mesh.current.position.y,
      -pointer.y * 0.3,
      0.1
    )
  })

  return (
    <Dodecahedron args={[1.2, 0]} ref={mesh}> {/* ✅ Only radius + detail */}
      <meshStandardMaterial
        color="#7c3aed"
        emissive="#7c3aed"
        emissiveIntensity={2}
        roughness={0.1}
        metalness={0.3}
      />
    </Dodecahedron>
  )
}

export default function DodecahedronOrb() {
  return (
    <div className="w-full h-64 relative">
      <Canvas
        className="absolute inset-0"
        camera={{ position: [0, 0, 4] }}
        style={{ background: 'transparent' }}
      >
        <ambientLight intensity={0.2} />
        <OrbMesh />
        <EffectComposer>
          <Bloom strength={1.2} radius={0.6} threshold={0} />
        </EffectComposer>
      </Canvas>
    </div>
  )
}