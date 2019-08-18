#include <iostream>
using namespace std;

int cnt;
char input[151][31];
int firstName[26];

int main()
{
	cin >> cnt;
	for (int i = 0; i < cnt; i++)
	{
		cin >> input[i];

		firstName[input[i][0] - 'a']++;
	}
	
	bool flag = false;
	for (int i = 0; i < 26; i++)
	{
		if (firstName[i] >= 5)
		{
			cout << (char)('a' + i);
			flag = true;
		}
	}

	if (flag == false) cout << "PREDAJA";

	cout << '\n';
	return 0;

}