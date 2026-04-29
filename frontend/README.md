# DineQ Frontend

DineQ 백엔드(Spring Boot)와 짝을 이루는 React 프론트엔드입니다.

## 사전 준비 (Node 활성화)

이 프로젝트는 글로벌 Node를 건드리지 않습니다. 루트의 포터블 Node를 현재 터미널에만 적용해서 사용합니다.

DineQ 루트(`D:\etc\Work\DineQ`)에서:

```powershell
. .\use-node.ps1
```

`node -v` 가 `v24.x.x` 로 나오면 OK.

## 개발 서버 실행

```powershell
cd frontend
npm run dev
```

기본 주소: <http://localhost:3000>

## 환경 변수

- `frontend/.env.development`
  - `VITE_API_BASE_URL` : 백엔드 베이스 URL (기본 `http://localhost:8080`)

## 백엔드와 함께 띄우기

- 터미널 1 (백엔드): DineQ 루트에서 `./gradlew bootRun`
- 터미널 2 (프론트): `frontend` 폴더에서 `. ..\use-node.ps1` 후 `npm run dev`
