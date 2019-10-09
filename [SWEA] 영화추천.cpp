#ifndef _CRT_SECURE_NO_WARNINGS
#define _CRT_SECURE_NO_WARNINGS
#endif // !_CRT_SECURE_NO_WARNINGS

#include <stdio.h>
#include "Windows.h"
#include <cstdio>

#define SIZE 60005
#define MSIZE 5005
#define USIZE 1005
#define HASH_SIZE 5000*2+17
struct Node {
	int id;
	int newid;
	Node* next;
	Node* prev;
};

Node unodes[SIZE], mnodes[SIZE], hnodes[MSIZE];
int unidx, mnidx, hnidx;
int totalCnt;

Node* newUNode() {
	return &unodes[unidx++];
}
Node* newMNodes() {
	return &mnodes[mnidx++];
}
Node* newHNodes() {
	return &hnodes[hnidx++];
}

class List
{
public:
	Node head;
	Node tail;
	int cnt;
	List() {
		head.next = &tail;
		tail.prev = &head;
		cnt = 0;
	}
	void init() {
		head.next = &tail;
		tail.prev = &head;
		cnt = 0;
	}
	void insert(Node* newNode) {
		newNode->prev = &head;
		newNode->next = head.next;
		head.next->prev = newNode;
		head.next = newNode;
		cnt++;
	}

};

List movies[MSIZE];
List users[USIZE];
List hashTable[HASH_SIZE];
int mappingTable[MSIZE];
int movieCnt;

struct Candidate {
	int id;
	int samecnt;
	int totalcnt;
	Candidate() {};
	Candidate(int _id, int _samecnt, int _totalcnt) {
		id = _id, samecnt = _samecnt, totalcnt = _totalcnt;
	}
	bool operator<(Candidate& a) {
		if (samecnt == a.samecnt) {
			if (totalcnt == a.totalcnt) {
				return id > a.id;
			}
			return totalcnt < a.totalcnt;
		}
		return samecnt < a.samecnt;
	}

};

Candidate stack[1000];
int top;

void push(Candidate a) {
	stack[top++] = a;
}

Candidate pop() {
	return stack[--top];
}

int hashf(int mid) { return mid % HASH_SIZE; }

void init()
{
	unidx = 0; mnidx = 0;  hnidx;
	totalCnt = 0; movieCnt = 0;
	for (int i = 0; i < MSIZE; i++) {
		movies[i].init();
	}
	for (int i = 0; i < USIZE; i++) {
		users[i].init();
	}
	for (int i = 0; i < HASH_SIZE; i++) {
		hashTable[i].init();
	}
}

void register_id(int uid)
{
	totalCnt++;
}

int Getid(int id) {
	int key = hashf(id);
	Node* cur = hashTable[key].head.next;
	while (cur != &hashTable[key].tail) {
		if (cur->id == id)
		{
			return cur->newid;
		}
		cur = cur->next;
	}
	Node* newNode = newHNodes();
	newNode->id = id; newNode->newid = movieCnt++;
	hashTable[key].insert(newNode);

	return newNode->newid;
}

void register_movie(int mid)
{
	int id = Getid(mid);
	mappingTable[id] = mid;
}

void watch_movie(int uid, int mid)
{
	int id = Getid(mid);
	Node* m = newMNodes();
	m->id = id;
	users[uid].insert(m);
	Node* u = newUNode();
	u->id = uid;
	movies[id].insert(u);
}

int recommend_movie(int uid)
{
	int result = -1;
	//추천후보 사이즈
	int limit = (totalCnt < 100) ? 1 : totalCnt / 100;
	int check[1000] = { 0, };


	top = 0;

	//같은 영화보는 user들
	Node* cur = users[uid].head.next;
	for (; cur != &users[uid].tail; cur = cur->next) {
		Node* cur2 = movies[cur->id].head.next;
		for (; cur2 != &movies[cur->id].tail; cur2 = cur2->next) {
			if (uid == cur2->id) continue;
			check[cur2->id]++;

		}

	}
	for (int i = 0; i < totalCnt; i++)
	{
		if (check[i] != 0)
			push(Candidate(i, check[i], users[i].cnt));
	}
	//같은영화 안보는 user들
	for (int k = 0; k < totalCnt; k++) {
		if (check[k] != 0)continue; //같은영화를 보는 user제외
		if (users[k].cnt != 0 && uid != k)
			push(Candidate(k, 0, users[k].cnt));
	}
	//limit 만큼 선택정렬
	int size = top;
	for (int i = 0; i < size - 1; i++) {
		if (limit == i)
			break;
		Candidate max = stack[i]; int midx = i;

		for (int j = i + 1; j < size; j++) {
			if (max < stack[j]) {
				max = stack[j];
				midx = j;
			}
		}
		if (i != midx) {
			Candidate tmp = stack[midx];
			stack[midx] = stack[i];
			stack[i] = tmp;
		}
	}

	size = (size < limit) ? size : limit;

	int mcheck[5005] = { 0, };
	int rcheck[5005] = { 0, };//.............
						//추천할 user과 본 영화들

	for (Node* cur = users[uid].head.next; cur != &users[uid].tail; cur = cur->next) {
		mcheck[cur->id]++;

	}
	int r = 0;
	int rid = -1;
	for (int i = 0; i < size; i++) {
		int unum = stack[i].id;
		for (Node* cur = users[unum].head.next; cur != &users[unum].tail; cur = cur->next) {
			if (mcheck[cur->id] == 0) {
				rcheck[cur->id]++;
				if (rcheck[cur->id] > r) { //추천횟수가 더크다면
					r = rcheck[cur->id];
					rid = cur->id;
				}
				else if (rcheck[cur->id] == r && cur->id > rid) // 추천횟수가 같다면 id값이 더크다면
				{
					r = rcheck[cur->id];
					rid = cur->id;

				}
			}
		}

	}
	if (rid != -1) return mappingTable[rid];
	return rid;

}

enum CommandType { INIT, USER_ADD, MOVIE_ADD, WATCH, RECOMMEND };

int main()
{
	freopen("in.txt", "r", stdin);
	int begin = GetTickCount();
	int T;
	scanf("%d", &T);

	for (register int test_case = 1; test_case <= T; ++test_case)
	{
		bool isOk;

		int commandsCount, command, arg1, arg2, retval, answer;
		scanf("%d", &commandsCount);
		int t = 1;
		while (commandsCount--)
		{
			scanf("%d", &command);

			switch (command)
			{
			case INIT:
				isOk = true;
				init();
				break;

			case USER_ADD:
				scanf("%d", &arg1);
				register_id(arg1);
				break;

			case MOVIE_ADD:
				scanf("%d", &arg2);
				register_movie(arg2);
				break;

			case WATCH:
				scanf("%d %d", &arg1, &arg2);
				watch_movie(arg1, arg2);
				break;

			case RECOMMEND:
				scanf("%d", &arg1);
				if (test_case == 5 && t == 840)
					int a = 1;
				retval = recommend_movie(arg1);

				scanf("%d", &answer);
				if (retval != answer)

					printf("testcase: %d t: %d ans : %d re: %d\n", test_case, t, answer, retval);
				isOk &= (retval == answer);
				break;

			}
			t++;
		}

		printf("#%d %d\n", test_case, isOk == true ? 100 : 0);
	}
	int end = GetTickCount();
	printf("걸린 시간 : %d\n", end - begin);
}