package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.Task;
import com.example.shikgoomoim.service.TaskService;
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
import java.util.UUID;

@Tag(name = "할일 Controller", description = "할일 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "가족 아이디로 할일 조회", description = "특정 가족의 할일 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "할일 목록 조회 성공",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Task.class))))
    @GetMapping("/{familyId}")
    public Optional<List<Task>> getTaskByFamilyId(
            @Parameter(description = "가족 아이디", required = true)
            @PathVariable Long familyId) {
        return taskService.getTaskByFamilyId(familyId);
    }

    @Operation(summary = "할일 추가", description = "새로운 할일을 추가하고 할일 아이디를 반환합니다.")
    @ApiResponse(responseCode = "200", description = "할일 추가 성공",
            content = @Content(schema = @Schema(implementation = Long.class)))
    @PostMapping("/add")
    public Long addTask(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "추가할 할일 정보", required = true,
                    content = @Content(schema = @Schema(implementation = Task.class)))
            @RequestBody Task task) {
        // 랜덤 UUID로 세팅, 수정 => id 중복 확인해야함
        task.setTaskId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        taskService.addTask(task);
        return task.getTaskId();
    }

    @Operation(summary = "할일 삭제", description = "특정 할일을 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "할일 삭제 성공")
    @DeleteMapping("/remove/{taskId}")
    public void removeTask(
            @Parameter(description = "삭제할 할일의 아이디", required = true)
            @PathVariable Long taskId) {
        taskService.removeTask(taskId);
    }
}
