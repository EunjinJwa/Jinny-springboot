package springboot.sample.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.sample.domain.Member;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController {

    List<Member> memberList = new ArrayList<>();

    Gson gson = new Gson();

    @GetMapping(value="/test/members")
    @ApiOperation(value = "get member list", notes = "멤버 목록을 조회.")
    public ResponseEntity<Object> getMembers() {
        return new ResponseEntity<>(gson.toJson(memberList), HttpStatus.OK);
    }

    @PostMapping(value="/test/members", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "register member", notes = "멤버 등록")
    public ResponseEntity<Object> registerMembers(@RequestBody Member member) {
        memberList.add(member);
        return new ResponseEntity<>(gson.toJson(memberList), HttpStatus.OK);
    }

}
