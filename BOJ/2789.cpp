#include <iostream>
using namespace std;

int cardCnt;
int target;
int card[101];
bool check[101];
int maxNum = 0;

bool solve(int cnt, int sum)
{
	if (cnt == 3)
	{
		if (sum == target)
		{
			maxNum = sum;
			return true;
		}
		if (maxNum  < sum && sum <= target)
		{
			maxNum = sum;
			
		}
		return false;
	}

	for (int i = 0; i < cardCnt; i++)
	{
		if (check[i] == false && sum + card[i] <= target)
		{
			check[i] = true;
			if(solve(cnt + 1, sum + card[i]) == true) return true;
			check[i] = false;
		}
	}
}

int main()
{
	cin >> cardCnt >> target;
	for (int i = 0; i < cardCnt; i++) cin >> card[i];
	solve(0, 0);
	
	cout << maxNum << endl;

	return 0;
}