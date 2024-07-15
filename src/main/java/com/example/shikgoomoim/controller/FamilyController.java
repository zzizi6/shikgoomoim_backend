package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.Family;
import com.example.shikgoomoim.service.FamilyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "가족 Controller", description = "가족 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/family")
public class FamilyController {

    private final FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @Operation(summary = "가족 아이디로 가족 조회", description = "특정 가족의 정보를 조회합니다.")
    @GetMapping("/{familyId}")
    public Family getFamily(
            @Parameter(description = "가족 아이디", required = true) @PathVariable Long familyId) {
        return familyService.getFamilyById(familyId);
    }

    @Operation(summary = "가족 추가", description = "새로운 가족을 추가합니다.")
    @PostMapping("/add")
    public void addFamily(@RequestBody Family family) {
        familyService.addFamily(family);
    }

    @Operation(summary = "가족 삭제", description = "특정 가족을 삭제합니다.")
    @DeleteMapping("/remove/{familyId}")
    public void removeFamily(
            @Parameter(description = "삭제할 가족의 아이디", required = true) @PathVariable Long familyId) {
        familyService.removeFamily(familyId);
    }

}
