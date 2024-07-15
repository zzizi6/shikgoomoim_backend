package com.example.shikgoomoim.controller;

import com.example.shikgoomoim.entity.Event;
import com.example.shikgoomoim.service.EventService;
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

@Tag(name = "이벤트 Controller", description = "이벤트 관련 API를 제공합니다.")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @Operation(summary = "가족 아이디로 이벤트 조회", description = "특정 가족의 이벤트 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "이벤트 목록 조회 성공",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Event.class))))
    @GetMapping("/{familyId}")
    public Optional<List<Event>> getEvent(
            @Parameter(description = "가족 아이디", required = true)
            @PathVariable Long familyId) {
        return eventService.getEventByFamilyId(familyId);
    }

    @Operation(summary = "이벤트 추가", description = "새로운 이벤트를 추가합니다.")
    @ApiResponse(responseCode = "200", description = "이벤트 추가 성공")
    @PostMapping("/add")
    public void addEvent(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "추가할 이벤트 정보", required = true,
                    content = @Content(schema = @Schema(implementation = Event.class)))
            @RequestBody Event event) {
        eventService.addEvent(event);
    }

    @Operation(summary = "이벤트 삭제", description = "특정 이벤트를 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "이벤트 삭제 성공")
    @DeleteMapping("/remove/{eventId}")
    public void removeEvent(
            @Parameter(description = "삭제할 이벤트의 아이디", required = true)
            @PathVariable Long eventId) {
        eventService.removeEvent(eventId);
    }
}
