#include <iostream>
using namespace std;


char num1[102], num2[102], oper, temp;
int num1Cnt, num2Cnt;

void output()
{
	if (oper == '+')
	{
		if (num1Cnt > num2Cnt)
		{
			for (int i = 0; i < num1Cnt; i++)
			{
				if (num1Cnt - i == num2Cnt) cout << "1";
				else cout << num1[i]-'0';
			}
		}
		else if (num1Cnt < num2Cnt)
		{
			for (int i = 0; i < num2Cnt; i++)
			{
				if (num2Cnt -i == num1Cnt) cout << "1";
				else cout << num2[i] - '0';
			}
		}
		else
		{
			for (int i = 0; i < num2Cnt; i++)
			{
				if (i == 0) cout << "2";
				else cout << num1[i] - '0';
			}
		}
	}
	else if (oper == '*')
	{
		cout << "1";
		for (int i = 1; i <= num1Cnt + num2Cnt -2; i++)
		{
			cout << "0";
		}
	}
	cout << '\n';
}

int main()
{
	oper = '\0';
	cin >> num1 >> oper >> num2;

	while (num1[++num1Cnt] != '\0');
	while (num2[++num2Cnt] != '\0');

	output();
	return 0;
}