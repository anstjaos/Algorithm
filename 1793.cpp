#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string dp[251];

string bigAdd(string num1, string num2)
{
	long long sum = 0;
	string result;

	while (!num1.empty() || !num2.empty() || sum)
	{
		if (!num1.empty())
		{
			sum += num1.back() - '0';
			num1.pop_back();
		}
		if (!num2.empty())
		{
			sum += num2.back() - '0';
			num2.pop_back();
		}

		result.push_back((sum % 10) + '0');
		sum /= 10;
	}

	reverse(result.begin(), result.end());
	return result;
}

int main()
{
	dp[0] = '1', dp[1] = '1';
	
	for (int i = 2; i <= 250; i++)
	{
		dp[i] = bigAdd(bigAdd(dp[i - 2], dp[i-2]),  dp[i - 1]);
	}

	int num;
	while (scanf("%d", &num) != EOF)
	{
		cout << dp[num] << "\n";
	}
	return 0;
}