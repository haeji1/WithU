import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }, proxy: {
    '/map': {
      target: 'http://localhost:8080/spring', // 실제 백엔드 서버 주소와 포트
      ws: true,
      changeOrigin: true,
    },
  },
})
