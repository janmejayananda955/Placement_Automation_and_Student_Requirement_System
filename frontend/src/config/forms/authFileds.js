export const loginFields = [
  {
    label: "Email",
    type: "email",
    name: "email",
    placeholder: "Enter your email",
    required: true,
  },
  {
    label: "Password",
    type: "password",
    name: "password",
    placeholder: "Enter your password",
    required: true,
  },
];

export const registerFields = [
  {
    label: "Name",
    type: "text",
    name: "name",
    placeholder: "Enter your name",
    required: true,
  },
  {
    label: "Email",
    type: "email",
    name: "email",
    placeholder: "Enter your email",
    required: true,
  },
  {
    label: "Password",
    type: "password",
    name: "password",
    placeholder: "Create password",
    required: true,
  },
];

export const loginHeaderAndFooterConfig = {
  header: {
    title: "Sign in",
    subtitle: "Sign in below to access your account",
  },
  footer: {
    text: "Don’t have an account yet?",
    linkText: "Sign up",
    link: "/register",
  },
};

export const registerHeaderAndFooterConfig = {
  header: {
    title: "Create Account",
    subtitle: "Fill details to register",
  },
  footer: {
    text: "Already have an account?",
    linkText: "Sign in",
    link: "/login",
  },
};