package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.Memory;
import com.example.shikgoomoim.service.MemoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "추억 Controller", description = "추억 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/memory")
public class MemoryController {

    private final MemoryService memoryService;

    @Autowired
    public MemoryController(MemoryService memoryService) {
        this.memoryService = memoryService;
    }

    @Operation(summary = "가족 아이디로 추억 조회", description = "특정 가족의 추억을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "추억 목록 조회 성공",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Memory.class))))
    @GetMapping("/{familyId}")
    public Optional<List<Memory>> getMemoryByFamilyId(
            @Parameter(description = "가족 아이디", required = true)
            @PathVariable Long familyId) {
        return memoryService.getMemoryByFamilyId(familyId);
    }

    @Operation(summary = "추억 추가", description = "새로운 추억을 추가합니다.")
    @ApiResponse(responseCode = "200", description = "추억 추가 성공")
    @PostMapping("/add")
    public void addMemory(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "추가할 추억 정보", required = true,
                    content = @Content(schema = @Schema(implementation = Memory.class)))
            @RequestBody Memory memory) {
        memoryService.addMemory(memory);
    }

    @Operation(summary = "추억 삭제", description = "특정 추억을 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "추억 삭제 성공")
    @DeleteMapping("/remove/{memoryId}")
    public void removeMemory(
            @Parameter(description = "삭제할 추억의 아이디", required = true)
            @PathVariable Long memoryId) {
        memoryService.removeMemoryByMemoryId(memoryId);
    }
}
