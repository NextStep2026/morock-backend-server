#!/bin/bash
# 도커 컴포즈로 컨테이너 백그라운드 실행
docker-compose up -d

# 로그 바로 출력 (app 서비스만 보고 싶으면 'app' 추가 가능)
docker-compose logs -f
