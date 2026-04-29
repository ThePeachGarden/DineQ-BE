import { useEffect, useState } from 'react'
import apiClient from './api/client'
import './App.css'

function App() {
  const [status, setStatus] = useState('loading')
  const [menus, setMenus] = useState([])
  const [error, setError] = useState(null)

  useEffect(() => {
    apiClient
      .get('/api/v1/menus')
      .then((res) => {
        setMenus(Array.isArray(res.data) ? res.data : [])
        setStatus('ok')
      })
      .catch((err) => {
        setError(err?.message || 'unknown error')
        setStatus('error')
      })
  }, [])

  return (
    <div style={{ padding: 24, fontFamily: 'sans-serif' }}>
      <h1>DineQ Frontend</h1>
      <p>
        API base: <code>{import.meta.env.VITE_API_BASE_URL}</code>
      </p>

      {status === 'loading' && <p>메뉴 불러오는 중...</p>}

      {status === 'error' && (
        <div style={{ color: 'crimson' }}>
          <p>백엔드 호출 실패: {error}</p>
          <p>
            확인 사항: 백엔드가 <code>http://localhost:8080</code> 에서 떠 있는지,
            CORS에 <code>http://localhost:3000</code> 이 허용되어 있는지.
          </p>
        </div>
      )}

      {status === 'ok' && (
        <div>
          <p>
            연결 성공! 메뉴 카테고리 수: <strong>{menus.length}</strong>
          </p>
          <pre
            style={{
              background: '#f5f5f5',
              padding: 12,
              borderRadius: 6,
              maxHeight: 400,
              overflow: 'auto',
            }}
          >
            {JSON.stringify(menus, null, 2)}
          </pre>
        </div>
      )}
    </div>
  )
}

export default App
