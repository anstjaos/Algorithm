#include <iostream>
using namespace std;

typedef struct {
	int location;
	int num;
}maxNum;

int bingo[501][501],row,col;
maxNum check{ 0,0 };

int check9(int num)
{
	int result = 0;

	while (num != 0)
	{
		if (num % 10 == 9) result++;

		num = num / 10;
	}
	return result;
}

int main()
{
	int cnt = 0;
	int total = 0;
	cin >> row >> col;
	for (int i = 0; i < row; i++)
	{
		cnt = 0;
		for (int j = 0; j < col; j++)
		{
			cin >> bingo[i][j];
			cnt += check9(bingo[i][j]);
			total += check9(bingo[i][j]);
		}
		if (check.num < cnt)
		{
			check.location = i;
			check.num = cnt;
		
	
		}
	}
	
	for (int j = 0; j < col; j++)
	{
		cnt = 0;
		for (int i = 0; i < row; i++)
		{
			cnt += check9(bingo[i][j]);
		}
		if (check.num < cnt)
		{
			check.location = j;
			check.num = cnt;
		
		}
	}

	cout << total - check.num << endl;
	return 0;
}