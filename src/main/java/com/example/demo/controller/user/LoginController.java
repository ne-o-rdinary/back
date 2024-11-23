package com.example.demo.controller.user;

import com.example.demo.base.ApiResponse;
import com.example.demo.base.code.status.exception.ErrorStatus;
import com.example.demo.base.code.status.exception.GeneralException;
import com.example.demo.domain.entity.token.RefreshToken;
import com.example.demo.repository.token.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final RefreshTokenRepository refreshTokenRepository;

    /**
     * 유저 UUID를 받아서 해당 RefreshToken을 반환하는 API
     * @param userId UUID
     * @return RefreshToken 정보
     
    @GetMapping("/api/login/{userId}")
    public ResponseEntity<ApiResponse<RefreshToken>> login(@PathVariable UUID userId) {
        // UUID에 해당하는 RefreshToken을 데이터베이스에서 찾음
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId);

        // RefreshToken이 없으면 FETCH_FAILED 에러를 던짐
        if (refreshToken == null) {
            throw new GeneralException(ErrorStatus.FETCH_FAILED.getReasonHttpStatus());
        }

        // 정상적으로 토큰을 찾았다면 성공적인 응답 반환
        return ResponseEntity.ok(ApiResponse.onSuccess(refreshToken));
    }
    */
}
