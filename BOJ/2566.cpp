#include <iostream>
using namespace std;

int maxnum = 0;
int num;
int resultRow;
int resultCol;
int row = 1;
int col = 1;

int main()
{
	for (int i = 0; i < 81; i++)
	{
		if (col == 10)
		{
			row++;
			col = 1;
		}
		cin >> num;
		if (num > maxnum)
		{
			maxnum = num;
			resultRow = row;
			resultCol = col;
		}
		col++;
	}

	cout << maxnum << endl;
	cout << resultRow << " " << resultCol << endl;
}