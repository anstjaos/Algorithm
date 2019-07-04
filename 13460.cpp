#include <iostream>
#include <queue>
using namespace std;

struct Node {
	int d, rx, ry, bx, by;
};

char mat[10][11];
int n, m;
int fx, fy;
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int main() {
	scanf("%d%d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%s", mat[i]);
	int srx, sry, sbx, sby;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (mat[i][j] == 'R')
				srx = i, sry = j;
			else if (mat[i][j] == 'B')
				sbx = i, sby = j;
			else if (mat[i][j] == 'O')
				fx = i, fy = j;

	queue<Node> q;
	q.push({ 0, srx, sry, sbx, sby });

	int ans = -1;
	while (!q.empty()) {
		int cnt = q.front().d;
		int rx = q.front().rx;
		int ry = q.front().ry;
		int bx = q.front().bx;
		int by = q.front().by;
		q.pop();
		if (cnt == 10)
			break;
		for (int i = 0; i < 4; i++) {
			//���� ���� �������� ��쿡��
			int rex = 0;
			int blue = 0;
			int nrx, nry;
			int rmove = 0;
			nrx = rx + dx[i];
			nry = ry + dy[i];
			while (mat[nrx][nry] != '#') {
				rmove++;
				//���� �濡 B�� �ִ� ���
				if (nrx == bx && nry == by)
					blue = rmove;
				//���� �濡 ������ �ִ� ���
				if (mat[nrx][nry] == 'O')
					rex = rmove;
				nrx += dx[i];
				nry += dy[i];
			}
			bool bex = false;
			bool red = false;
			int nbx, nby;
			int bmove = 0;
			nbx = bx + dx[i];
			nby = by + dy[i];
			while (mat[nbx][nby] != '#') {
				bmove++;
				//���� �濡 R�� �ִ� ���
				if (nbx == rx && nby == ry)
					red = true;
				//���� �濡 ������ �ִ� ���
				if (mat[nbx][nby] == 'O')
					bex = true;
				nbx += dx[i];
				nby += dy[i];
			}
			//���� ���� ������ ���� ���
			if (!blue && !red) {

				if (rex) {
					ans = cnt + 1;
					printf("%d\n", ans);
					return 0;
				}
				else if (bex) {
					continue;
				}
				else {
					q.push({ cnt + 1, rx + dx[i] * rmove, ry + dy[i] * rmove, bx + dx[i] * bmove, by + dy[i] * bmove });
				}
			}
			//R�� ���� �濡 B�� �ִ� ���
			else if (blue) {
				//������ B���� ���ʿ� �ִ� ��� �ϳ� ���ߴ�
				if (rex) {
					if (rex < blue) {
						ans = cnt + 1;
						printf("%d\n", ans);
						return 0;
					}
					continue;
				}
				else {
					rmove--;
					q.push({ cnt + 1, rx + dx[i] * rmove, ry + dy[i] * rmove, bx + dx[i] * bmove, by + dy[i] * bmove });
				}
			}
			//B�� ���� �濡 R�� �ִ� ���
			else {
				if (rex) {
					continue;
				}
				else {
					bmove--;
					q.push({ cnt + 1, rx + dx[i] * rmove, ry + dy[i] * rmove, bx + dx[i] * bmove, by + dy[i] * bmove });
				}
			}
		}
	}

	printf("%d\n", ans);
	return 0;
}