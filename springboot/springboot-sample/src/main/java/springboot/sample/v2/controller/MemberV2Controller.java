package springboot.sample.v2.controller;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.sample.domain.Member;
import springboot.sample.exception.NotExistExceptionextends;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2")
@Api(tags = "member")
public class MemberV2Controller {

    List<Member> memberList = new ArrayList<>();

    Gson gson = new Gson();

    @GetMapping(value="/test/members")
    @ApiOperation(value = "get member list", notes = "멤버 목록을 조회.")
    public ResponseEntity<List<Member>> getMembers() {
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }

    @GetMapping(value="/test/members/{memberId}")
    @ApiOperation(value = "get member list", notes = "멤버 조회.")
    public ResponseEntity<Member> getMemberByMemberId(
            @ApiParam(value = "member id", required = true, example = "1")
            @PathVariable String memberId

    ) {
        for (Member member : memberList) {
            if (member.getUserId().equals(memberId)) {
                return new ResponseEntity<Member>(member, HttpStatus.OK);
            }
        }
        throw new NotExistExceptionextends(memberId);
    }


    @PostMapping(value="/test/members", consumes = "application/json", produces = "application/json")
    @ApiOperation(value = "register member", notes = "멤버 등록")
    public ResponseEntity<Object> registerMembers(@RequestBody Member member) {
        memberList.add(member);
        return new ResponseEntity<>(memberList, HttpStatus.OK);
    }



}
