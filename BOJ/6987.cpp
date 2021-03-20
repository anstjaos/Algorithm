#include <iostream>
using namespace std;

typedef struct {
	int win, draw, lose;
}match;

match matchArr[6];
bool result[4];

void solve(int testCase, int p, int q)
{
	if (p == 6)
	{
		result[testCase] = true;
	
	}
	else if (q == 6) solve(testCase, p + 1, p + 2);
	else
	{
		matchArr[p].win--;
		matchArr[q].lose--;
		if (matchArr[p].win >= 0 && matchArr[q].lose >= 0) solve(testCase, p, q + 1);
		matchArr[p].win++;
		matchArr[q].lose++;

		matchArr[p].draw--;
		matchArr[q].draw--;
		if (matchArr[p].draw >= 0 && matchArr[q].draw >= 0) solve(testCase, p, q + 1);
		matchArr[p].draw++;
		matchArr[q].draw++;

		matchArr[p].lose--;
		matchArr[q].win--;
		if (matchArr[p].lose >= 0 && matchArr[q].win >= 0) solve(testCase, p, q + 1);
		matchArr[p].lose++;
		matchArr[q].win++;
	}
}

int main()
{
	for (int i = 0; i < 4; i++)
	{
		int sum = 0;
		for (int j = 0; j < 6; j++)
		{
			cin >> matchArr[j].win >> matchArr[j].draw >> matchArr[j].lose;
			sum = sum + matchArr[j].win + matchArr[j].draw + matchArr[j].lose;
		}

		if (sum != 30)
		{
			result[i] = false;
			continue;
		}

		solve(i, 0, 1);
	}

	for (int i = 0; i < 4; i++)
	{
		if (result[i] == false) cout << "0 ";
		else cout << "1 ";
	}
	cout << '\n';
	return 0;
}