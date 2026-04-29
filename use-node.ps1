# DineQ 전용 포터블 Node 활성화 스크립트
# 사용법: 새 터미널에서  . .\use-node.ps1   (점 + 공백 + 스크립트 경로)
# 효과: 현재 PowerShell 세션에서만 PATH 앞에 포터블 Node를 끼워넣음.
#       터미널을 닫으면 효과는 사라지며, 시스템/다른 사용자/다른 프로젝트엔 영향 없음.

$NodeDir = "D:\etc\Work\DineQ\.tools\node24\node-v24.15.0-win-x64"

if (-not (Test-Path (Join-Path $NodeDir "node.exe"))) {
    Write-Host "[use-node] node.exe not found at: $NodeDir" -ForegroundColor Red
    Write-Host "[use-node] 포터블 Node 압축 해제 위치를 확인하세요." -ForegroundColor Yellow
    return
}

if ($env:PATH -notlike "$NodeDir*") {
    $env:PATH = "$NodeDir;" + $env:PATH
}

Write-Host "[use-node] PATH 적용 완료 (이 터미널 한정)" -ForegroundColor Green
Write-Host "[use-node] node $(node -v) / npm $(npm -v)"
