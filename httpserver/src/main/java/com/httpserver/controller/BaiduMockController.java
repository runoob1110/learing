package com.httpserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/11/19 15:24
 */
@RestController
public class BaiduMockController {

    @GetMapping("/integration-service/road-net/cross")
    public String getCrossList(@RequestParam Integer page, @RequestParam Integer size) {
        return "{\n" +
                "    \"data\": {\n" +
                "        \"content\": [\n" +
                "            {\n" +
                "                \"cross_id\": \"aaaaa\",\n" +
                "                \"cross_name\": \"aaaaa\",\n" +
                "                \"longitude\": 10,\n" +
                "                \"latitude\": 100\n" +
                "            }\n" +
                "        ],\n" +
                "        \"pageable\": {\n" +
                "            \"sort\": {\n" +
                "                \"unsorted\": false,\n" +
                "                \"sorted\": true\n" +
                "            },\n" +
                "            \"pageNumber\": 0,\n" +
                "            \"pageSize\": 10,\n" +
                "            \"offset\": 0,\n" +
                "            \"unpaged\": false,\n" +
                "            \"paged\": true\n" +
                "        },\n" +
                "        \"totalPages\": 1,\n" +
                "        \"totalElements\": 1,\n" +
                "        \"last\": true,\n" +
                "        \"first\": true,\n" +
                "        \"sort\": {\n" +
                "            \"unsorted\": false,\n" +
                "            \"sorted\": true\n" +
                "        },\n" +
                "        \"numberOfElements\": 1,\n" +
                "        \"size\": 1,\n" +
                "        \"number\": 0\n" +
                "    },\n" +
                "    \"code\": 200,\n" +
                "    \"msg\": \"OK\"\n" +
                "}";
    }


    @PostMapping("/integration-service/phase-hold/reset")
    public String resetHold() {
        return "{\"code\":500,\"msg\":\"OK\",\"data\":null}";
    }


    @PostMapping("/integration-service/phase-hold")
    public String hold() {
        return "{\"code\":500,\"msg\":\"OK\",\"data\":null}";
    }


    @PostMapping("/sso/oauth/token")
    public String token() {
        return "{\"access_token\":\"mock_access_token\",\"token_type\":\"Bearer\",\"expires_in\":3600,\"jti\":\"mock_jti\",\"refresh_token\":\"mock_refresh_token\",\"scope\":\"mock_scope\",\"nickname\":\"mock_nickname\"}";
    }

    @GetMapping("/integration-service/hold/control/phase/group")
    public String phaseGroupControl(HttpServletRequest request, @PathVariable String cross_id) {
        Enumeration<String> headerNames = request.getHeaderNames();
        return "{\n" +
                "    \"code\": 200,\n" +
                "    \"msg\": \"OK\",\n" +
                "    \"data\": {\n" +
                "        \"cross_id\": \"CS_0143_NG_NB1570698656_NB1520277434\",\n" +
                "        \"scheme_template_id\": 1,\n" +
                "        \"stage_groups\": [\n" +
                "            {\n" +
                "                \"stage_no\": \"1\",\n" +
                "                \"phase_list\": [\n" +
                "                    1\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"stage_no\": \"2\",\n" +
                "                \"phase_list\": [\n" +
                "                    2\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"stage_no\": \"3\",\n" +
                "                \"phase_list\": [\n" +
                "                    3\n" +
                "                ]\n" +
                "            },\n" +
                "            {\n" +
                "                \"stage_no\": \"4\",\n" +
                "                \"phase_list\": [\n" +
                "                    4\n" +
                "                ]\n" +
                "            }\n" +
                "        ],\n" +
                "        \"phase_groups\": [],\n" +
                "        \"channel_groups\": []\n" +
                "    }\n" +
                "}";
    }
}
