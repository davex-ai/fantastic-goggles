"use client"

import { Canvas, useFrame, useThree } from "@react-three/fiber"
import { Torus } from "@react-three/drei"
import { useRef } from "react"
import * as THREE from "three"
import { EffectComposer, Bloom } from "@react-three/postprocessing"
function OrbMesh() {
  const mesh = useRef<THREE.Mesh>(null)

  const { pointer } = useThree()

  useFrame(() => {
    if (!mesh.current) return

    // 🌀 Subtle rotation
    mesh.current.rotation.y += 0.01
    mesh.current.rotation.x += 0.005

    // 🖱️ Mouse parallax (updated every frame!)
    mesh.current.position.x = pointer.x * 0.3
    mesh.current.position.y = -pointer.y * 0.3
  })

  return (
    <Torus args={[1.2, 0.4, 32, 64]} ref={mesh}>
      <meshStandardMaterial
        color="#7c3aed"
        emissive="#7c3aed"
        emissiveIntensity={2} // 🔥 brighter emissive
        roughness={0.1}
        metalness={0.3}
      />
    </Torus>
  )
}

export default function RotatingRing() {
  return (
    <div className="w-full h-64 relative">
      <Canvas
        className="absolute inset-0"
        camera={{ position: [0, 0, 4] }}
        style={{ background: 'transparent' }}
      >
        <ambientLight intensity={0.2} /> {/* 🔆 Dim ambient so glow pops */}
        <OrbMesh />

        {/* ✨ Add bloom for true glow */}
        <EffectComposer>
          <Bloom
            strength={1.2}
            radius={0.6}
            threshold={0}
          />
        </EffectComposer>
      </Canvas>
    </div>
  )
}