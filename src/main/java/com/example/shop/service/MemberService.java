package com.example.shop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.shop.common.ResponseEntity;
import com.example.shop.member.Member;
import com.example.shop.member.MemberRepository;
import com.example.shop.member.MemberRequest;

@Service
public class MemberService {
	private MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResponseEntity<List<Member>> findAll() {
		return new ResponseEntity<>(
			HttpStatus.OK.value(),
			memberRepository.findAll(),
			memberRepository.count()
		);
	}

	public ResponseEntity<Member> create(MemberRequest request) {
		// TODO
		Member member = new Member(
			UUID.randomUUID(),
			request.email(),
			request.name(),
			request.password(),
			request.phone(),
			request.saltKey(),
			request.flag()
		);

		Member saved = memberRepository.save(member);
		return new ResponseEntity<>(HttpStatus.OK.value(), saved, 1);
	}

	public ResponseEntity<Member> update(MemberRequest request, String id) {
		// TODO
		Member member = new Member(
			id,
			request.email(),
			request.name(),
			request.password(),
			request.phone(),
			request.saltKey(),
			request.flag()
		);

		Member updated = memberRepository.save(member);
		return new ResponseEntity<>(HttpStatus.OK.value(), updated, 1);
	}

	public ResponseEntity<Void> delete(String id) {
		memberRepository.deleteById(UUID.fromString(id));
		return new ResponseEntity<>(HttpStatus.OK.value(), null, 0);
	}
}
