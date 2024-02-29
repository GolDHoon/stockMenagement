package com.gdh.stockMenagement.config;

import com.gdh.stockMenagement.repository.basic.CodeRepository;
import com.gdh.stockMenagement.repository.basic.LogiCodeRepository;
import com.gdh.stockMenagement.repository.basic.UkcdCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CodeRepository codeRepository;
    private final LogiCodeRepository logiCodeRepository;
    private final UkcdCodeRepository ukcdCodeRepository;

    @Override
    public void run(String... args) throws Exception{
        // 이곳에서 DB 데이터를 로드하고 객체를 생성하는 코드를 작성합니다.
    }
}