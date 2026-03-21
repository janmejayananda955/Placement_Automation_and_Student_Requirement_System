/* This code snippet is a React component named `Register` that represents a registration form. Here's
a breakdown of what the code is doing: */
/* This code snippet is a React component named `Register` that represents a registration form. Here's
a breakdown of what the code is doing: */
import React from "react";
import { Form } from "../../../components/ui/Form";
import { FormHeader } from "../../../components/ui/FormHeader";
import { Input } from "../../../components/ui/Input";
import { Button } from "../../../components/ui/Button";
import { FormFooter } from "../../../components/ui/FormFooter";

import {
  registerFields,
  registerHeaderAndFooterConfig,
} from "../../../config/forms/authFileds";
import { toast } from "react-toastify";
import { registerUser } from "../services/authService";
const Register = () => {
  const { header, footer } = registerHeaderAndFooterConfig;

  const handleRegister = () => {};

  return (
    <Form onSubmit={handleRegister}>
      <FormHeader headerText={header.title} pText={header.subtitle} />
      <div className="mt-0.5">
        {registerFields.map((field) => (
          <Input 
          label={field.label}
          key={field.name}
          {...field} />
          
        ))}

        <Button type="submit" text={"Sign up"} />
        <FormFooter
          linkPath={footer.link}
          text={footer.text}
          linkText={footer.linkText}
        />
      </div>
    </Form>
  );
};

export default Register;
