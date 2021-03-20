#include <iostream>
using namespace std;

const int MAX = 100;

struct DigitData {
	short digit;
	short count;

	DigitData() {};
	DigitData(short digit, short count) : digit(digit), count(count) {};
};

struct DigitHeap {
	int count;
	DigitData data[MAX];

	DigitHeap() : count(0) {};

	void add(DigitData dd) {
		data[count].count = dd.count;
		data[count].digit = dd.digit;

		count++;

		adjust2Top();
	}

	DigitData pop() {
		DigitData ret = data[0];

		data[0] = data[--count];
		adjust2bottom();

		return ret;
	}

	bool isEmpty() {
		return count == 0;
	}

private:
	void adjust2bottom()
	{
		int pos = 0;

		while (pos * 2 + 1 < count || pos * 2 + 2 < count)
		{
			int nextPos = count;
			if (pos * 2 + 2 < count)
			{
				if (isBigger(pos, pos * 2 + 1) || isBigger(pos, pos * 2 + 2)) {
					nextPos = isBigger(pos * 2 + 1, pos * 2 + 2) ? pos * 2 + 2 : pos * 2 + 1;

					swap(data[pos], data[nextPos]);

					pos = nextPos;
				}
			}
			else if (pos * 2 + 1 < count) {
				if (isBigger(pos, pos * 2 + 1)) {
					swap(data[pos], data[pos * 2 + 1]);
					nextPos = pos * 2 + 1;
				}
			}
			pos = nextPos;
		}
	}

	void adjust2Top()
	{
		int pos = count - 1;

		while (pos != (pos - 1) / 2 && isBigger((pos - 1) / 2, pos))
		{
			swap(data[pos], data[(pos - 1) / 2]);
			pos = (pos - 1) / 2;
		}
	}

	bool isBigger(int origin, int cmp) {
		if (data[origin].count > data[cmp].count)
			return true;
		else if (data[origin].count == data[cmp].count)
			return data[origin].digit > data[cmp].digit;
		return false;
	}
};

void funcR(int origin[MAX][MAX], int des[MAX][MAX], int& row, int& col)
{
	int rowMax = 0;
	for (int i = 0; i < col; i++)
	{
		DigitHeap heap;
		int digit[MAX + 1] = {};

		for (int j = 0; j < row; j++) {
			if (origin[i][j])
				digit[origin[i][j]]++;
		}

		for (int j = 1; j < MAX + 1; j++)
			if (digit[j] > 0)
				heap.add(DigitData(j, digit[j]));

		int count = 0;
		while (!heap.isEmpty() && count < 100) {
			DigitData cur = heap.pop();

			des[i][count++] = cur.digit;
			des[i][count++] = cur.count;
		}

		if (rowMax < count)
			rowMax = count;
	}

	row = rowMax;
}

void funcC(int origin[MAX][MAX], int des[MAX][MAX], int& row, int& col)
{
	int colMax = 0;
	for (int i = 0; i < row; i++)
	{
		DigitHeap heap;
		int digit[MAX + 1] = {};

		for (int j = 0; j < col; j++) {
			if (origin[j][i])
				digit[origin[j][i]]++;
		}

		for (int j = 1; j < MAX + 1; j++)
			if (digit[j] > 0)
				heap.add(DigitData(j, digit[j]));

		int count = 0;
		while (!heap.isEmpty() && count < 100) {
			DigitData cur = heap.pop();

			des[count++][i] = cur.digit;
			des[count++][i] = cur.count;
		}

		if (colMax < count)
			colMax = count;
	}

	col = colMax;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(0);

	int r, c, k;
	int curRow = 3, curCol = 3;

	cin >> r >> c >> k;

	int board[MAX][MAX] = {};

	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			cin >> board[i][j];

	int res = -1;

	for (int i = 0; i <= MAX; i++)
	{
		if (board[r - 1][c - 1] == k)
		{
			res = i;
			break;
		}

		int copyBoard[MAX][MAX] = {};

		if (curRow > curCol)
			funcC(board, copyBoard, curRow, curCol);
		else
			funcR(board, copyBoard, curRow, curCol);

		for (int j = 0; j < curCol; j++)
			for (int k = 0; k < curRow; k++)
				board[j][k] = copyBoard[j][k];
	}

	cout << res << "\n";

	return 0;
}
//#include <iostream>
//#include <algorithm>
//using namespace std;
//
//#define MAX_SIZE 100
//#define MAX_NUM 1001
//
//typedef struct {
//	int num;
//	int cnt;
//}Info;
//
//int rowCnt, colCnt, arr[MAX_SIZE][MAX_SIZE], result;
//int numArr[MAX_NUM],r ,c, k, infoCnt;
//Info infoArr[MAX_SIZE * MAX_SIZE + 1];
//
//bool comp(Info &a, Info &b)
//{
//	if (a.cnt == b.cnt) {
//		return a.num < b.num;
//	}
//	return a.cnt < b.cnt;
//}
//
//int changeRow(int row)
//{
//	infoCnt = 0;
//	for (register int i = 1; i < MAX_NUM; i++) {
//		numArr[i] = 0;
//	}
//
//	for (register int j = 0; j < colCnt; j++) {
//		numArr[arr[row][j]]++;
//		arr[row][j] = 0;
//	}
//
//	for (register int i = 1; i < MAX_NUM; i++) {
//		if (numArr[i] != 0) {
//			infoArr[infoCnt] = { i, numArr[i] };
//			infoCnt++;
//		}
//	}
//
//	sort(infoArr, infoArr + infoCnt, comp);
//	infoCnt = min(50, infoCnt);
//	for (register int j = 0; j < infoCnt; j++) {
//		arr[row][j * 2] = infoArr[j].num;
//		arr[row][j * 2 + 1] = infoArr[j].cnt;
//	}
//	return infoCnt * 2;
//}
//
//int changeCol(int col)
//{
//	infoCnt = 0;
//	for (register int i = 1; i < MAX_NUM; i++) {
//		numArr[i] = 0;
//	}
//
//	for (register int i = 0; i < rowCnt; i++) {
//		numArr[arr[i][col]]++;
//		arr[i][col] = 0;
//	}
//
//	for (register int i = 1; i < MAX_NUM; i++) {
//		if (numArr[i] != 0) {
//			infoArr[infoCnt] = { i, numArr[i] };
//			infoCnt++;
//		}
//	}
//	sort(infoArr, infoArr + infoCnt, comp);
//	infoCnt = min(50, infoCnt);
//	for (register int j = 0; j < infoCnt; j++) {
//		arr[j*2][col] = infoArr[j].num;
//		arr[j*2+1][col] = infoArr[j].cnt;
//	}
//	return infoCnt * 2;
//}
//
//void solve()
//{
//	while (1)
//	{
//		if (arr[r - 1][c - 1] == k) break;
//		if (result > 100) break;
//
//		if (rowCnt >= colCnt) {
//			int colTemp = 0;
//			for (register int i = 0; i < rowCnt; i++) {
//				colTemp = max(colTemp, changeRow(i));
//			}
//			colCnt = colTemp;
//		}
//		else {
//			int rowTemp = 0;
//			for (register int i = 0; i < colCnt; i++) {
//				rowTemp = max(rowTemp, changeCol(i));
//			}
//			rowCnt = rowTemp;
//		}
//
//		result++;
//	}
//}
//
//int main()
//{
//	scanf("%d %d %d", &r, &c, &k);
//	rowCnt = colCnt = 3;
//	for (register int i = 0; i < rowCnt; i++) {
//		for (register int j = 0; j < colCnt; j++) {
//			scanf("%d", &arr[i][j]);
//		}
//	}
//
//	solve();
//	result > 100 ? printf("-1\n") : printf("%d\n", result);
//	return 0;
//}