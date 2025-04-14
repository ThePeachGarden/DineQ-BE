package com.dineq.dineqbe.service;

import com.dineq.dineqbe.domain.entity.QREntity;
import com.dineq.dineqbe.repository.QRRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class QRService {

    private final QRRepository qrRepository;

    public QRService(QRRepository qrRepository) {
        this.qrRepository = qrRepository;
    }

    private static final String CHAR_POOL = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int RANDOM_LENGTH = 10;
    private static final SecureRandom random = new SecureRandom();

    public String generateRandomToken(){
        String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));

        StringBuilder randomPart = new StringBuilder();
        for (int i = 0; i < RANDOM_LENGTH; i++) {
            int index = random.nextInt(CHAR_POOL.length());
            randomPart.append(CHAR_POOL.charAt(index));
        }

        return timestamp + randomPart;
    }

    public String registerQR(String tableId) {
        String token= generateRandomToken();
        System.out.println("현재 생성된 랜덤 토큰:" + (token));

        QREntity qrEntity = new QREntity();
        qrEntity.setToken(token);
        qrEntity.setTableId(tableId);

        qrRepository.save(qrEntity);
        return token;
    }
}
