package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.User;
import com.example.shikgoomoim.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 Controller", description = "유저 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "유저 아이디로 유저 조회", description = "특정 유저의 정보를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "유저 정보 조회 성공",
            content = @Content(schema = @Schema(implementation = User.class)))
    @GetMapping("/{userId}")
    public User getUserInfo(
            @Parameter(description = "조회할 유저의 아이디", required = true)
            @PathVariable String userId) {
        System.out.println(userService.getUserById(userId).getUserId());
        return userService.getUserById(userId);
    }


}
