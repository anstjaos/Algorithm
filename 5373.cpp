#include <stdio.h>

enum {U = 0, D, F, B, L, R};
char cube[6][3][3], input[1001][2];
int tc, N;
int moveDir[6][2][4][3] = {
	{
		{{F,0,1},{L,0,1},{B,2,1},{R,0,1}},	// 시계
		{{F,0,1},{R,0,1},{B,2,1},{L,0,1}}	// 반시계
	}, // U
	{
		{{F,2,1},{R,2,1},{B,0,1},{L,2,1}},	// 시계
		{{F,2,1},{L,2,1},{B,0,1},{R,2,1}}	// 반
	}, // D
	{
		{{U,2,1},{R,0,0},{D,0,1},{L,2,0}},	// 시
		{{U,2,1},{L,2,0},{D,0,1},{R,0,0}}	// 반
	}, // F
	{
		{{U,0,1},{L,0,0},{D,2,1},{R,2,0}},	// 시
		{{U,0,1},{R,2,0},{D,2,1},{L,0,0}}	// 반
	}, // B
	{
		{{U,0,0},{F,0,0},{D,0,0},{B,0,0}},	// 시
		{{U,0,0},{B,0,0},{D,0,0},{F,0,0}}	// 반
	}, // L
	{
		{{U,2,0},{B,2,0},{D,2,0},{F,2,0}},	// 시
		{{U,2,0},{F,2,0},{D,2,0},{B,2,0}}	// 반
	} // R
}; // 1 row 0 col

void init()
{
	char c;
	for (register int i = 0; i < 6; i++) {
		switch (i) {
		case 0:
			c = 'w';
			break;
		case 1:
			c = 'y';
			break;
		case 2:
			c = 'r';
			break;
		case 3:
			c = 'o';
			break;
		case 4:
			c = 'g';
			break;
		case 5:
			c = 'b';
			break;
		}
		for (register int j = 0; j < 3; j++) {
			for (register int k = 0; k < 3; k++) {
				cube[i][j][k] = c;
			}
		}
	}
}

void selfRotate(int shape, int dir)
{
	char temp[3][3];
	if (dir == 0)	// 시계
	{
		for (register int i = 0; i < 3; i++) {
			for (register int j = 0; j < 3; j++) {
				temp[j][2-i] = cube[shape][i][j];
			}
		}
	}
	else {	// 반시계
		for (register int i = 0; i < 3; i++) {
			for (register int j = 0; j < 3; j++) {
				temp[2 - j][i] = cube[shape][i][j];
			}
		}
	}

	for (register int i = 0; i < 3; i++) {
		for (register int j = 0; j < 3; j++) {
			cube[shape][i][j] = temp[i][j];
		}
	}
}

void rotateCube(int shape, int dir)
{
	char save[3], temp[3];

	if (moveDir[shape][dir][0][2] == 1) {
		for (register int i = 0; i < 3; i++) {
			temp[i] = cube[moveDir[shape][dir][0][0]][moveDir[shape][dir][0][1]][i];
		}
	}
	else {
		for (register int i = 0; i < 3; i++) {
			temp[i] = cube[moveDir[shape][dir][0][0]][i][moveDir[shape][dir][0][1]];
		}
	}

	for (register int i = 0; i < 4; i++)
	{
		int idx = (i + 1) % 4;
		if (moveDir[shape][dir][idx][2] == 1) {	// row
			for (register int j = 0; j < 3; j++) {
				if (moveDir[shape][dir][idx][0] == B && shape != L && shape != R) {
					save[2-j] = cube[moveDir[shape][dir][idx][0]][moveDir[shape][dir][idx][1]][2-j];
					cube[moveDir[shape][dir][idx][0]][moveDir[shape][dir][idx][1]][2-j] = temp[j];
				}
				else {
					save[j] = cube[moveDir[shape][dir][idx][0]][moveDir[shape][dir][idx][1]][j];
					cube[moveDir[shape][dir][idx][0]][moveDir[shape][dir][idx][1]][j] = temp[j];
				}
			}
		}
		else {
			for (register int j = 0; j < 3; j++) {	//col
				if (moveDir[shape][dir][idx][0] == B && shape != L && shape != R) {
					save[2-j] = cube[moveDir[shape][dir][idx][0]][2-j][moveDir[shape][dir][idx][1]];
					cube[moveDir[shape][dir][idx][0]][2-j][moveDir[shape][dir][idx][1]] = temp[j];
				}
				else {
					save[j] = cube[moveDir[shape][dir][idx][0]][j][moveDir[shape][dir][idx][1]];
					cube[moveDir[shape][dir][idx][0]][j][moveDir[shape][dir][idx][1]] = temp[j];
				}
			}
		}
	
		///
		for (register int j = 0; j < 3; j++) {
			temp[j] = save[j];
		}
	}
}

void solve()
{
	int shape;
	int dir; // 0 시계 1 반시계
	for (register int i = 0; i < N; i++) {
		switch (input[i][0]) {
		case 'U':
			shape = U;
			break;
		case 'D':
			shape = D;
			break;
		case 'F':
			shape = F;
			break;
		case 'B':
			shape = B;
			break;
		case 'L':
			shape = L;
			break;
		case 'R':
			shape = R;
			break;
		}

		if (input[i][1] == '+') dir = 0;
		else dir = 1;

		selfRotate(shape, dir);	// 자기 자신 회전
		rotateCube(shape, dir);	// 주위 큐브 회전
	}
}

int main()
{
	scanf("%d", &tc);
	for (register int t = 0; t < tc; t++) {
		init();
		scanf("%d", &N);
		for (register int i = 0; i < N; i++) {
			scanf("%s", input[i]);
		}
		solve();

		for (register int i = 0; i < 3; i++) {
			for (register int j = 0; j < 3; j++) {
				printf("%c", cube[U][i][j]);
			}
			printf("\n");
		}
	}
	return 0;
}