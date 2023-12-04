package com.devworks.springdatajpapocs;

import com.devworks.springdatajpapocs.dshibernate.UserGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/user-groups")
public class UserGroupController {

    private final UserGroupService userGroupService;

    public UserGroupController(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping
    public ResponseEntity<List<UserGroup>> getGroups() {
        List<UserGroup> userGroups = userGroupService.getGroups();
        return ResponseEntity.ok(userGroups);
    }

}
