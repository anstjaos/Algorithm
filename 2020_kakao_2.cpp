#include <string>
#include <vector>
using namespace std;

bool isCorrect(char *input)
{
	int openCnt = 0, closeCnt = 0;
	for (register int i = 0; input[i] != 0; i++) {
		if (input[i] == '(') openCnt++;
		else closeCnt++;

		if (closeCnt > openCnt) return false;
	}
	return true;
}

string solve(char *input)
{
	string answer = "";
	if (isCorrect(input)) {
		for (register int i = 0; input[i] != 0; i++) answer += input[i];
		return answer;
	}

	register int i = 0;

	int openCnt = 0, closeCnt = 0;
	bool check = true;

	if (input[0] == ')') check = false;
	for (; input[i] != 0; i++) {
		if (input[i] == '(') openCnt++;
		else closeCnt++;

		if (openCnt == closeCnt) break;
	}
	i++;

	if (check) {
		for (register int j = 0; j < i; j++) answer += input[j];
		answer += solve(&input[i]);
	}
	else {
		answer += '(';
		answer += solve(&input[i]);
		answer += ')';
		for (register int j = 1; j < i - 1; j++) {
			if (input[j] == '(') answer += ')';
			else answer += '(';
		}
	}

	return answer;
}

string solution(string p) {
	string answer = "";
	int size = p.size();
	char input[1005] = { 0, };
	for (register int i = 0; i < size; i++) {
		input[i] = p[i];
	}
	input[size] = 0;

	answer = solve(input);

	return answer;
}

#include <iostream>
int main()
{
	cout << solution("))))((((");
}