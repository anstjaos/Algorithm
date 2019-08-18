#include <stdio.h>
#include <queue>
using namespace std;

#define MAX_SIZE 101

typedef struct {
	int y;
	int x;
}Point;

typedef struct {
	bool alive;
	int speed;
	int dir;
	int size;
	Point pt;
}Shark;

int row, col, M, r, c, s, d, z, map[MAX_SIZE][MAX_SIZE], res;
int dirY[5] = {0, -1,1,0,0 }, dirX[5] = { 0,0,0,1,-1 };
Shark sharkArr[MAX_SIZE * MAX_SIZE + 5];

void arrangeShark()
{
	for (register int i = 1; i <= row; i++) {
		for (register int j = 1; j <= col; j++) map[i][j] = 0;
	}

	for (register int i = 1; i <= M; i++) {
		if (!sharkArr[i].alive) continue;

		Point cur = sharkArr[i].pt;
		if (map[cur.y][cur.x] != 0) {
			if (sharkArr[map[cur.y][cur.x]].size < sharkArr[i].size) {
				sharkArr[map[cur.y][cur.x]].alive = false;
				map[cur.y][cur.x] = i;
			}
			else sharkArr[i].alive = false;
		}
		else map[cur.y][cur.x] = i;
	}
}

void changeShark(Shark &s)
{
	int remain = s.speed;
	switch (s.dir) { 
	case 1:
	case 2:
		remain %= (row * 2 - 2);
		while (remain > 0) {
			if (s.pt.y == 1) {
				s.dir = 2;
			}
			if (s.pt.y == row) {
				s.dir = 1;
			}
			s.pt.y += dirY[s.dir];
			remain--;
		}
		break;
		//좌우
	case 3:
	case 4:
		remain %= (col * 2 - 2);
		while (remain > 0) {
			if (s.pt.x == 1) {
				s.dir = 3;
			}
			if (s.pt.x == col) {
				s.dir = 4;
			}
			s.pt.x += dirX[s.dir];
			remain--;
		}
		break;
	}
	
	/*while (remain != 0)
	{
		switch (s.dir)
		{
		case 1:
			if (s.pt.y - 1 > remain) {
				remain -= (s.pt.y - 1);
				s.pt.y = 1;
				s.dir = 2;
			} 
			else {
				s.pt.y -= remain;
				remain = 0;
			}
			break;
		case 2:
			if (row - s.pt.y > remain) {
				remain -= (row - s.pt.y);
				s.pt.y = row;
				s.dir = 1;
			}
			else {
				s.pt.y += remain;
				remain = 0;
			}
			break;
		case 3: // 우
			if (col - s.pt.x > remain) {
				remain -= (col - s.pt.x);
				s.pt.x = col;
				s.dir = 4;
			}
			else {
				s.pt.x += remain;
				remain = 0;
			}
			break;
		case 4:
			if (s.pt.x - 1 > remain) {
				remain -= (s.pt.x - 1);
				s.pt.x = 1;
				s.dir = 3;
			}
			else {
				s.pt.x -= remain;
				remain = 0;
			}
			break;
		}
	}*/
}

void moveShark()
{
	for (register int i = 1; i <= M; i++) {
		if (!sharkArr[i].alive) continue;

		changeShark(sharkArr[i]);
	}
}

void solve()
{
	for (register int i = 1; i <= col; i++) {
		arrangeShark();// 상어 정리
		for (register int j = 1; j <= row; j++) {// 상어 잡기
			if (map[j][i] != 0) {
				res += sharkArr[map[j][i]].size;
				sharkArr[map[j][i]].alive = false;
				break;
			}
		}
		moveShark();// 상어 이동
	}
}

int main()
{
	scanf("%d %d %d", &row, &col, &M);
	for (register int i = 1; i <= M; i++) {
		scanf("%d %d %d %d %d", &r, &c, &s, &d, &z);
		sharkArr[i] = { true, s, d, z, {r,c} };
	}

	solve();
	printf("%d\n", res);
	return 0;
}