#include <string>
#include <vector>
#include <iostream>
using namespace std;

int result, row, col;
bool memo[48][48][1 << 4];
typedef struct {
	int x;
	int y;
}pt;

//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
class Solution {
private:
	int max(int a, int b) { return (a > b ? a : b); }

	bool isPossible(pt dot) {
		if (dot.x < 0 || dot.y < 0 || dot.x >= row || dot.y >= col) return false;

		return true;
	}

	void solve(string board[48], int cnt) {
		result = max(result, cnt);

		for (register int i = 0; i < row; i++) {
			for (register int j = 0; j < col; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'X';
					pt dot1, dot2;

					///// case1
					dot1 = { i, j + 1 };
					dot2 = { i + 1,j };

					if (isPossible(dot1) && isPossible(dot2)) {
						if (board[dot1.x][dot1.y] == '.' && board[dot2.x][dot2.y] == '.') {
							if (memo[i][j][1 << 0] == false) {
								board[dot1.x][dot1.y] = 'X';
								board[dot2.x][dot2.y] = 'X';
								solve(board, cnt + 1);
								board[dot1.x][dot1.y] = '.';
								board[dot2.x][dot2.y] = '.';
								memo[i][j][1 << 0] = true;
							}
						}
					}

					///// case2
					dot1 = { i, j + 1 };
					dot2 = { i - 1,j };

					if (isPossible(dot1) && isPossible(dot2)) {
						if (board[dot1.x][dot1.y] == '.' && board[dot2.x][dot2.y] == '.') {
							if (memo[i][j][1 << 1] == false) {
								board[dot1.x][dot1.y] = 'X';
								board[dot2.x][dot2.y] = 'X';
								solve(board, cnt + 1);
								board[dot1.x][dot1.y] = '.';
								board[dot2.x][dot2.y] = '.';
								memo[i][j][1 << 1] = true;
							}
						}
					}

					///// case3
					dot1 = { i, j - 1 };
					dot2 = { i + 1,j };

					if (isPossible(dot1) && isPossible(dot2)) {
						if (board[dot1.x][dot1.y] == '.' && board[dot2.x][dot2.y] == '.') {
							if (memo[i][j][1 << 2] == false) {
								board[dot1.x][dot1.y] = 'X';
								board[dot2.x][dot2.y] = 'X';
								solve(board, cnt + 1);
								board[dot1.x][dot1.y] = '.';
								board[dot2.x][dot2.y] = '.';
								memo[i][j][1 << 2] = true;
							}
						}
					}

					///// case4
					dot1 = { i, j - 1 };
					dot2 = { i - 1,j };

					if (isPossible(dot1) && isPossible(dot2)) {
						if (board[dot1.x][dot1.y] == '.' && board[dot2.x][dot2.y] == '.') {
							if (memo[i][j][1 << 3] == false) {
								board[dot1.x][dot1.y] = 'X';
								board[dot2.x][dot2.y] = 'X';
								solve(board, cnt + 1);
								board[dot1.x][dot1.y] = '.';
								board[dot2.x][dot2.y] = '.';
								memo[i][j][1 << 3] = true;
							}
						}
					}

					board[i][j] = '.';
				}
			}
		}

	}
public:
	int solution(string board[48]) {
		result = 0;
		for (register int i = 0; i < 48; i++) {
			for (register int j = 0; j < 48; j++) {
				for (register int k = 0; k < 4; k++) {
					memo[i][j][1 << k] = false;
				}
			}
		}

		solve(board, 0);

		return result;
	}
};

int main()
{
	string board[48];

	cin >> row >> col;
	for (int i = 0; i < row; i++) cin >> board[i];
	Solution s;
	int result = s.solution(board);
	cout << result << "\n";
	return 0;
}