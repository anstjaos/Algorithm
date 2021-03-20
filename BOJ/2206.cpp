//#include <iostream>
//using namespace std;
//
//typedef struct {
//	int x;
//	int y;
//	bool breakWall;
//}mv;
//char map[1001][1001];
//int row, col, result = 2123456789;
//mv queue[100001];
//int temp[1001][1001];
//int front, rear;
//bool visit[1001][1001][2];
//int dirX[4] = { -1,0,1,0 };
//int dirY[4] = { 0,1,0,-1 };
//
//void push(mv item)
//{
//	rear = (rear + 1) % 100001;
//	queue[rear] = item;
//}
//
//void pop() 
//{
//	front = (front + 1) % 100001;
//}
//
//mv getFront()
//{
//	int temp = (front + 1) % 100001;
//	return queue[temp];
//}
//
//void bfs()
//{
//
//	
//	for (int i = 0; i < row; i++)
//	{
//		for (int j = 0; j < col; j++)
//		{
//			visit[i][j][0] = false;
//			visit[i][j][1] = false;
//			temp[i][j] = 0;
//		}
//	}
//
//	front = rear = -1;
//	push({ 0,0,false });
//	temp[0][0] = 1;
//	mv cur;
//
//	while (front != rear)
//	{
//		cur = getFront();
//		pop();
//		if (cur.x == row - 1 && cur.y == col - 1) break;
//		if (visit[cur.x][cur.y][cur.breakWall] == true) continue;
//		visit[cur.x][cur.y][cur.breakWall] = true;
//
//		for (int i = 0; i < 4; i++)
//		{
//			int nextX = cur.x + dirX[i];
//			int nextY = cur.y + dirY[i];
//
//			if (nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
//
//			if (visit[nextX][nextY][cur.breakWall] == false && map[nextX][nextY] == '0')
//			{
//				if(cur.breakWall == true) push({ nextX,nextY,true });
//				else push({ nextX,nextY,false });
//
//				temp[nextX][nextY] = temp[cur.x][cur.y] + 1;
//			}
//			else if (visit[nextX][nextY][cur.breakWall] == false && map[nextX][nextY] == '1' && cur.breakWall == false)
//			{
//				push({ nextX,nextY, true });
//				temp[nextX][nextY] = temp[cur.x][cur.y] + 1;
//			}
//		}
//	}
//
//	if (temp[row - 1][col - 1] != 0)
//	{
//		if (temp[row - 1][col - 1] < result) result = temp[row - 1][col - 1];
//	}
//}
//
//int main()
//{
//	cin >> row >> col;
//	for (int i = 0; i < row; i++) cin >> map[i];
//
//	bfs();
//
//	if (result == 2123456789) cout << "-1" << endl;
//	else cout << result << endl;
//
//	return 0;
//}

#include<iostream>
using namespace std;

int H, W;

int map[2000][2000];
int visit[2000][2000][2];

typedef struct Pos {
	int x, y, val;
}Pos;

Pos queue[100000];
int front = -1, rear = -1;
void enQueue(Pos p) {
	rear = (rear + 1) % 100000;
	queue[rear] = p;
}
Pos deQueue() {
	front = (front + 1) % 100000;
	return queue[front];
}
bool isEmpty() {
	return front == rear;
}


int dx[] = { 1, -1, 0, 0 };
int dy[] = { 0, 0, 1, -1 };


int main() {

	scanf("%d %d", &H, &W);

	for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			scanf("%1d", &map[i][j]);
		}
	}

	Pos start = { 0,0,1 };
	enQueue(start);
	
	visit[start.y][start.x][1] = 1;

	while (!isEmpty()) {
		Pos t = deQueue();

		for (int i = 0; i < 4; i++) {
			Pos nextPos = {t.x + dx[i], t.y + dy[i], t.val };
			if (nextPos.x >= 0 && nextPos.x < W && nextPos.y >= 0 && nextPos.y < H) {
				if (map[nextPos.y][nextPos.x] == 0 && (visit[nextPos.y][nextPos.x][nextPos.val] == 0 || visit[nextPos.y][nextPos.x][nextPos.val] > visit[t.y][t.x][t.val] + 1)) {
					enQueue(nextPos);
					visit[nextPos.y][nextPos.x][nextPos.val] = visit[t.y][t.x][t.val] + 1;
				}
				
				if (map[nextPos.y][nextPos.x] == 1 && nextPos.val == 1 &&
					(visit[nextPos.y][nextPos.x][0] == 0 || visit[nextPos.y][nextPos.x][0] > visit[t.y][t.x][1] + 1)) {
					nextPos.val = 0;
					enQueue(nextPos);
					visit[nextPos.y][nextPos.x][0] = visit[t.y][t.x][1] + 1;
				}
			}

		}

	}

	if (visit[H - 1][W - 1][0] == 0 && visit[H - 1][W - 1][1] == 0) {
		printf("-1\n");
		return 0;
	}
	int ret = visit[H - 1][W - 1][0];
	if (ret == 0) ret = visit[H - 1][W - 1][1];
	else if (visit[H - 1][W - 1][1] != 0 && visit[H - 1][W - 1][1] < ret) ret = visit[H - 1][W - 1][1];

	printf("%d\n", ret);
	return 0;
}