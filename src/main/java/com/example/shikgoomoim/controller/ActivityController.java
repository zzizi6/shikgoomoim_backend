package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.Activity;
import com.example.shikgoomoim.service.ActivityService;
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


@Tag(name = "활동 Controller", description = "활동 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/activity")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Operation(summary = "가족 아이디로 활동 조회", description = "특정 가족의 활동 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "활동 목록 조회 성공",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Activity.class))))
    @GetMapping("/{familyId}")
    public Optional<List<Activity>> getActivityByFamilyId(
            @Parameter(description = "가족 아이디", required = true)
            @PathVariable Long familyId) {
        return activityService.getActivityByFamilyId(familyId);
    }

    @Operation(summary = "활동 추가", description = "새로운 활동을 추가합니다.")
    @ApiResponse(responseCode = "200", description = "활동 추가 성공")
    @PostMapping("/add")
    public void addActivity(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "추가할 활동 정보", required = true,
                    content = @Content(schema = @Schema(implementation = Activity.class)))
            @RequestBody Activity activity) {
        activityService.addActivity(activity);
    }

    @Operation(summary = "활동 삭제", description = "특정 활동을 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "활동 삭제 성공")
    @DeleteMapping("/remove/{activityId}")
    public void removeActivity(
            @Parameter(description = "삭제할 활동의 아이디", required = true)
            @PathVariable Long activityId) {
        activityService.removeActivity(activityId);
    }
}
