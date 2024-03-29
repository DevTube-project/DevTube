module.exports = {
  root: true,
  env: { browser: true, es2020: true },
  extends: [
    'eslint:recommended',
    'plugin:@typescript-eslint/recommended',
    'plugin:react-hooks/recommended',
  ],
  ignorePatterns: ['dist', '.eslintrc.cjs'],
  parser: '@typescript-eslint/parser',
  plugins: ['react-refresh'],
	rules: {
    'react/no-unknown-property': ['error', { ignore: ['css'] }], // emotion사용을 위한 린트
		'react-refresh/only-export-components': ['warn', { checkJS: true }],
		'@typescript-eslint/no-explicit-any': 0, // any타입을 에러표시할지 체크.
		'@typescript-eslint/no-var-requires': 0,
		'@typescript-eslint/explicit-module-boundary-types': 0,
		'no-console': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
		'no-debugger': process.env.NODE_ENV === 'production' ? 'warn' : 'off',
		'eol-last': ['error', 'always'],
		semi: ['error', 'always'],
		quotes: ['error', 'single', { allowTemplateLiterals: true }],
		indent: ['error', 'tab', { SwitchCase: 1 }],
		'comma-dangle': [
			'error',
			{
				arrays: 'always-multiline',
				objects: 'always-multiline',
				functions: 'only-multiline',
				imports: 'only-multiline',
			},
		],
		'object-curly-spacing': ['error', 'always', { objectsInObjects: true }],
		'arrow-parens': ['error', 'always'],
		'react-hooks/rules-of-hooks': 'error', // Checks rules of Hooks
		'react-hooks/exhaustive-deps': 'warn', // Checks effect dependencies
		'react/self-closing-comp': [
			'error',
			{
				component: true,
				html: true,
			},
		],
		'jsx-quotes': ['error', 'prefer-double'],
		'react/jsx-no-target-blank': ['error', { allowReferrer: false }],
		'react/jsx-max-props-per-line': ['error', { maximum: 1 }],
		'react/jsx-indent': [
			'error',
			'tab',
			{
				checkAttributes: true,
				indentLogicalExpressions: false,
			},
		],
		'react/prop-types': ['error', { skipUndeclared: true }],
		'react/jsx-no-undef': 'off',
		'react/no-unescaped-entities': [
			'off',
			{
				forbid: [
					{
						char: '<',
						alternatives: ['&lt;'],
					},
					{
						char: '>',
						alternatives: ['&gt;'],
					},
					{
						char: '{',
						alternatives: ['&#123;'],
					},
					{
						char: '}',
						alternatives: ['&#125;'],
					},
				],
			},
		],
		'@typescript-eslint/no-unused-vars': 'warn',
	},
}